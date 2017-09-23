package me.duyu.home

//import kotlin.system.exitProcess;
import io.vertx.core.Vertx
import io.vertx.core.VertxOptions
import io.vertx.core.http.HttpServerOptions

fun main(args : Array<String>)
{
    val options = VertxOptions();
    options.setEventLoopPoolSize(4);
    //options.setWorkerPoolSize(16);
    val vertx = Vertx.vertx(options);
    val httpOptions = HttpServerOptions();
    httpOptions.maxHeaderSize = 16 * 1024;
    val router = buildRouter(vertx);

    println("start Server Main listen the server in 8082");
    val mainServer = vertx.createHttpServer(httpOptions);
    mainServer.requestHandler(router::accept).listen(8082);

    // 开启多个线程处理eventloop
    for(i in 0 until  options.eventLoopPoolSize) {
        println("start Server $i listen the server in 8082");
        val server = vertx.createHttpServer(httpOptions);
        server.requestHandler(router::accept).listen(8082);
    }
    println("main run end!!!");

    /*下面while(true)加上不影响执行，说明main函数执行完上面操作之后一直都是空闲的了，所有的操作都在vertx的线程里处理的。
    */
//    while(true)
//        Thread.sleep(500 * 1000);
    /*
    经过调试看出，此线程在执行完毕之后就自动退出了。
    vertx 默认只启动一个apecct 和 一个eventloop的处理线程，其他几个是请求过来了动态创建的。
    * */
}
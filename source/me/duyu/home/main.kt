package me.duyu.home

//import kotlin.system.exitProcess;
import io.vertx.core.Vertx
import io.vertx.core.VertxOptions
import io.vertx.core.http.HttpServerOptions

fun main(args : Array<String>)
{
    val options = VertxOptions();
    //options.setWorkerPoolSize(16);
    val vertx = Vertx.vertx(options);
    val httpOptions = HttpServerOptions();
    httpOptions.maxHeaderSize = 16 * 1024;
    val server = vertx.createHttpServer(httpOptions);

    val router = buildRouter(vertx);
    println("eun the server in 8082");
    server.requestHandler(router::accept).listen(8082);

}
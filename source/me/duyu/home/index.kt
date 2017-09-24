package me.duyu.home

import io.vertx.ext.web.RoutingContext
import java.lang.Thread.*


fun showIndex(context : RoutingContext)
{
    val a = currentThread()
    println(a.id)
    val req = context.request();
    println(req.path());
    val rep = context.response();
    rep.statusCode = 200;
    rep.end("hello world!")
}


fun showIndexSync(context : RoutingContext)
{
    val a = currentThread()
    println("sync thread ID : ${a.id}")
    Thread.sleep(1000);
    val req = context.request();
    println(req.path());
    val rep = context.response();
    rep.statusCode = 200;
    rep.end("hello world!")
}
package me.duyu.home

import io.vertx.ext.web.RoutingContext
import java.lang.Thread.*


fun showIndex(context : RoutingContext)
{
    val a = currentThread()
    println(a.id)
    val rep = context.response();
    rep.statusCode = 200;
    rep.end("hello world!")
}

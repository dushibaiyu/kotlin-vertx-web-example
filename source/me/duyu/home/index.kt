package me.duyu.home

import io.vertx.ext.web.RoutingContext

fun showIndex(context : RoutingContext)
{
    val rep = context.response();
    rep.statusCode = 200;
    rep.end("hello world!")
}

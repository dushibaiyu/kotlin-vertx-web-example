package me.duyu.home

import io.vertx.core.Vertx
import io.vertx.ext.web.Router

fun buildRouter(vertx : Vertx) : Router
{
    val router = Router.router(vertx);
    router.route().handler(::showIndex)
    return router;
}
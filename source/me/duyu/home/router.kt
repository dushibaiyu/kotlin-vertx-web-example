package me.duyu.home

import io.vertx.core.Vertx
import io.vertx.ext.web.Router

fun buildRouter(vertx : Vertx) : Router
{
    val router = Router.router(vertx);
    // 在eventloop线程中执行
    router.route("/").handler(::showIndex)
    // 放到线程池中去执行, 不排队，无序
    router.route("/block").blockingHandler(::showIndexSync,false)

    return router;
}
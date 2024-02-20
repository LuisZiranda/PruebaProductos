package com.example.test1

data class CallApi(
    var products: List<Productos>,
    var total: String,
    var skip: String,
    var limit: String,
)
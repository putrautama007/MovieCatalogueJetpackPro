package com.b.moviecataloguemvvm.model.remote

class APIResponse<T>(val statusResponse: StatusResponse, val body: T?, val message: String?) {

    companion object {
        fun <T> success(body: T?): APIResponse<T> {
            return APIResponse(
                StatusResponse.SUCCESS,
                body,
                null
            )
        }

        fun <T> empty(msg: String, body: T?): APIResponse<T> {
            return APIResponse(
                StatusResponse.EMPTY,
                body,
                msg
            )
        }

        fun <T> error(msg: String, body: T?): APIResponse<T> {
            return APIResponse(
                StatusResponse.ERROR,
                body,
                msg
            )
        }
    }
}
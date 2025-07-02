package com.hutsy.core.domain.util

sealed class DataError {
    enum class Network {
        NOT_FOUND,
        BAD_REQUEST,
        UNAUTHORIZED,
        FORBIDDEN,
        CONFLICT,
        INTERNAL_SERVER_ERROR,
        BAD_GATEWAY,
        SERVICE_UNAVAILABLE,
        TIMEOUT,
        NO_INTERNET,
        UNKNOWN,
    }

    enum class Local {
        DISK_FULL,
        CACHE_CORRUPTION,
        INVALID_DATA_FORMAT,
        PERMISSION_DENIED,
    }
}
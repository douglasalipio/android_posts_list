package com.baseproject.interview.foundation

import com.baseproject.interview.data.remote.ApiHelper

open class BaseInteractorImp() : BaseInteractor {

    protected lateinit var apiHelper: ApiHelper

    constructor(apiHelper: ApiHelper) : this() {
        this.apiHelper = apiHelper
    }

}
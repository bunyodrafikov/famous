package com.brafik.famous.features.create

import com.brafik.famous.base.BaseViewModel
import com.brafik.famous.features.create.model.CreatePostAction
import com.brafik.famous.features.create.model.CreatePostEvent
import com.brafik.famous.features.create.model.CreatePostViewState

class CreatePostViewModel :
    BaseViewModel<CreatePostViewState, CreatePostAction, CreatePostEvent>(initialState = CreatePostViewState()) {
    override fun obtainEvent(viewEvent: CreatePostEvent) {
        TODO("Not yet implemented")
    }
}
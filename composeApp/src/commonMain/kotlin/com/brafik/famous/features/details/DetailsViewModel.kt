package com.brafik.famous.features.details

import com.brafik.famous.base.BaseViewModel
import com.brafik.famous.features.details.model.DetailsAction
import com.brafik.famous.features.details.model.DetailsEvent
import com.brafik.famous.features.details.model.DetailsViewState

class DetailsViewModel : BaseViewModel<DetailsViewState, DetailsAction, DetailsEvent>(initialState = DetailsViewState()) {
    override fun obtainEvent(viewEvent: DetailsEvent) {
    }
}
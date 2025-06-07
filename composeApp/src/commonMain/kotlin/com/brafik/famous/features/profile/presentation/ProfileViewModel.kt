package com.brafik.famous.features.profile.presentation

import com.brafik.famous.base.BaseViewModel
import com.brafik.famous.features.profile.presentation.models.ProfileAction
import com.brafik.famous.features.profile.presentation.models.ProfileEvent
import com.brafik.famous.features.profile.presentation.models.ProfileViewState

class ProfileViewModel :
    BaseViewModel<ProfileViewState, ProfileAction, ProfileEvent>(
        initialState = ProfileViewState(
            name = "Natalie",
            subscribers = "5.3m subscribers",
            isSubscribed = false,
            joinedIn = "Joined in 2017"
        )
    ) {
    override fun obtainEvent(viewEvent: ProfileEvent) {
        when (viewEvent) {
            is ProfileEvent.TabSelected -> viewState =
                viewState.copy(selectedTabIndex = viewEvent.selectedIndex)
        }
    }
}
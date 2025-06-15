package com.brafik.famous.features.drafts.presentation

import androidx.lifecycle.ViewModel
import com.brafik.famous.core.di.InjectProvider
import com.brafik.famous.features.drafts.domain.SaveDraftUseCase

class DraftViewModel: ViewModel() {
    private val saveDraftUseCase = SaveDraftUseCase(InjectProvider.getDatabase().getDraftDao())
}
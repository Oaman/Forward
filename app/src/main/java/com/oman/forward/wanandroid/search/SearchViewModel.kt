package com.oman.forward.wanandroid.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {
    val key = MutableLiveData<String>()

    val searchResult = Transformations.switchMap(key) {
        SearchRepository.getSearchResult(1, it)
    }
}
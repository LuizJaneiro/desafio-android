package com.picpay.desafio.android.ui.get_users

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.domain.usecase.GetUsersUseCase
import com.picpay.desafio.android.domain.utils.result.onFailure
import com.picpay.desafio.android.domain.utils.result.onSuccess
import com.picpay.desafio.android.ui.model.User
import com.picpay.desafio.android.ui.model.ViewModelState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

internal class GetUsersViewModel(
    private val getUsersUseCase: GetUsersUseCase,
    private val dispatcher: CoroutineContext
) : ViewModel(), DefaultLifecycleObserver {

    private val _getUsersState: MutableStateFlow<ViewModelState<List<User>>> = MutableStateFlow(
        ViewModelState.Loading
    )
    val getUsersState: StateFlow<ViewModelState<List<User>>> = _getUsersState

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch(dispatcher) {
            _getUsersState.emit(ViewModelState.Loading)
            getUsersUseCase.invoke(Unit)
                .onSuccess {
                    _getUsersState.emit(ViewModelState.Success(it))
                }
                .onFailure {
                    _getUsersState.emit(ViewModelState.Error(it))
                }
        }
    }

}

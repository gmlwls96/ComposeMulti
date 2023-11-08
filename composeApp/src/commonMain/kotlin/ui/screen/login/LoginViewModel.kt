package ui.screen.login

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
//    private val userRepository: UserRepository
) : ViewModel(){
    private val _email: MutableStateFlow<String> = MutableStateFlow("")
    val email = _email.asStateFlow()
    private val _password: MutableStateFlow<String> = MutableStateFlow("")
    val password = _password.asStateFlow()

    val fillState = combine(email, password){ e, pw ->
        e.isNotEmpty() && pw.isNotEmpty()
    }

    private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    val isLoginButtonVisible = isLoading.map { it.not() }

    fun onLoginButtonPressed() {
        val emailValue = email.value
        val passwordValue = password.value

        viewModelScope.launch {
            _isLoading.value = true

            try {
//                userRepository.login(email = emailValue, password = passwordValue)
            } catch (error: Throwable) {
                val message = error.message ?: error.toString()
                val errorDesc = message

            } finally {
                _isLoading.value = false
            }
        }
    }

    fun changeEmail(text: String){
        _email.update { text }
    }

    fun changePassword(pw:String){
        _password.update { pw }
    }
}
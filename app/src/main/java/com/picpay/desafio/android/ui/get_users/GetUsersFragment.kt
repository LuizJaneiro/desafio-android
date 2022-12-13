package com.picpay.desafio.android.ui.get_users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.picpay.desafio.android.R
import com.picpay.desafio.android.databinding.FragmentGetUsersBinding
import com.picpay.desafio.android.ui.get_users.adapter.UserListAdapter
import com.picpay.desafio.android.ui.model.User
import com.picpay.desafio.android.ui.model.ViewModelState
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class GetUsersFragment : Fragment() {

    private val viewModel: GetUsersViewModel by viewModel()
    private val binding: FragmentGetUsersBinding by lazy {
        FragmentGetUsersBinding.inflate(layoutInflater)
    }
    private val adapter: UserListAdapter by lazy {
        UserListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycle.addObserver(viewModel)
        setupView()
        setObservers()
    }

    private fun setupView() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getUsersState.collect { state ->
                    when(state) {
                        is ViewModelState.Error -> handleError(state.error)
                        is ViewModelState.Loading -> showLoading()
                        is ViewModelState.Success -> handleSuccess(state.data)
                    }
                }
            }
        }
    }

    private fun handleError(throwable: Throwable) {
        binding.userListProgressBar.visibility = View.GONE
        binding.recyclerView.visibility = View.GONE

        Toast.makeText(requireContext(),
            throwable.cause?.message ?: getString(R.string.error),
            Toast.LENGTH_SHORT)
            .show()
    }

    private fun showLoading() {
        binding.userListProgressBar.visibility = View.VISIBLE
        binding.recyclerView.visibility = View.GONE
    }

    private fun handleSuccess(list: List<User>) {
        binding.userListProgressBar.visibility = View.GONE
        binding.recyclerView.visibility = View.VISIBLE
        adapter.submitList(list)
    }
}
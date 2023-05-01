package com.cookandroid.danggeunmarket_clone_project

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.cookandroid.danggeunmarket_clone_project.databinding.DialogCustomBinding

class CustomDialog(customDialogInterface: CustomDialogInterface, id: Int) : DialogFragment() {

    private var _binding: DialogCustomBinding? = null
    private val binding get() = _binding!!

    private var customDialogInterface: CustomDialogInterface? = null

    private var id: Int? = null

    init {
        this.id = id
        this.customDialogInterface = customDialogInterface
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DialogCustomBinding.inflate(inflater, container, false)
        val view = binding.root

        // 수정 버튼
        binding.updateBtn.setOnClickListener {
            Log.d("SQLTEST", "DELETEFUNCTION_SETONCLICK")
            this.customDialogInterface?.onUpdateBtnClick(id!!)
            dismiss()

        }

        // 삭제 버튼
        binding.deleteBtn.setOnClickListener {
            Log.d("SQLTEST", "DELETEFUNCTION_SETONCLICK")
            this.customDialogInterface?.onDeleteBtnClick(id!!)
            dismiss()

        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

interface CustomDialogInterface {
    fun onUpdateBtnClick(id: Int)
    fun onDeleteBtnClick(id: Int)
}
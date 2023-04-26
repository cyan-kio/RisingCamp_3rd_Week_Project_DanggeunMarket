package com.cookandroid.danggeunmarket_clone_project

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.danggeunmarket_clone_project.databinding.FragmentHomeBinding
import kotlinx.coroutines.NonDisposableHandle.parent

class HomeFragment : Fragment() {
    lateinit var sharedPreferences: SharedPreferences
    lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        binding.homeToolbar.setTitle("부흥동")

        sharedPreferences = requireActivity().getSharedPreferences("data", MODE_PRIVATE)

        val resellList = mutableListOf<ResellData>()
        for(i in 0..1) {
            resellList.add(ResellData(getDrawable(requireContext(), R.drawable.home_image_one)!!,"강문선님은 부흥동의 힘♥", "당근마켓", "하하하하하~\n하하하하하~\n하하하하하~\n하하하하하~\n",null, 0))
            resellList.add(ResellData(getDrawable(requireContext(), R.drawable.home_image_two)!!,"만삭임산부 관련 일괄팝니다(압박스타킹, 산전복대,", "호계동 · 끝올 5초 전", "싸게 팝니다. 연락 주세요. 싸게 팝니다. 연락 주세요. 싸게 팝니다. 연락 주세요. 싸게 팝니다. 연락 주세요.",  "30,000원", 0))
            resellList.add(ResellData(getDrawable(requireContext(), R.drawable.home_image_three)!!,"나이키 acg 플로럴 긴팔티 새상품", "광정동 · 5초 전", "급처. 편하게 연락주세요. 급처. 편하게 연락주세요. 급처. 편하게 연락주세요. 급처. 편하게 연락주세요. 급처. 편하게 연락주세요. 급처. 편하게 연락주세요. 급처. 편하게 연락주세요. ","52,000원", 0))
            resellList.add(ResellData(getDrawable(requireContext(), R.drawable.home_image_four)!!,"브리츠 스피커 판매합니다", "군포시 산본동 · 6초 전", "판매합니다. 판매합니다. 판매합니다. 판매합니다. 판매합니다. 판매합니다. 판매합니다. 판매합니다. 판매합니다. 판매합니다. ", "25,000원", 0))
            resellList.add(ResellData(getDrawable(requireContext(), R.drawable.home_image_five)!!,"이케아 침대협탁", "관악구 신림동 · 14초 전", "이케아 팝니다~ 이케아 팝니다~ 이케아 팝니다~ 이케아 팝니다~ 이케아 팝니다~","20,000원", 0))
            resellList.add(ResellData(getDrawable(requireContext(), R.drawable.home_image_six)!!,"프랭크스톤 여성 덕다운 패딩", "과천시 원문동 · 끝올 21초 전", "패딩 팝니다~~ 패딩 팝니다~~ 패딩 팝니다~~ 패딩 팝니다~~ 패딩 팝니다~~ 패딩 팝니다~~ 패딩 팝니다~~ ","17,000원", 3))
            resellList.add(ResellData(getDrawable(requireContext(), R.drawable.home_image_seven)!!,"[255] 이지부스트 350 v2 트리플블랙논리플", "호계1동 · 23초 전", "이지부스트~ 이지부스트~ 이지부스트~ 이지부스트~ 이지부스트~","180,000원", 0))
        }

        val adapter = HomeAdapter()
        adapter.data = resellList
        binding.homeRecyclerView.adapter = adapter
        binding.homeRecyclerView.layoutManager = LinearLayoutManager(context)

        // RecyclerView-Fab extend
        binding.homeRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if(dy > 0 && binding.homeFab.isExtended) {
                    binding.homeFab.shrink()
                } else if (dy < 0 && !binding.homeFab.isExtended) {
                    binding.homeFab.extend()
                }
            }
        })

        binding.homeFab.setOnClickListener {
            startActivity(Intent(requireActivity(), WriteActivity::class.java))
        }

        return binding.root
    }
}
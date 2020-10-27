package com.example;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.databinding.FragmentQuestionBinding;
import com.example.databinding.FragmentTitleBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public QuestionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuestionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuestionFragment newInstance(String param1, String param2) {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final MyViewModel viewModel = new ViewModelProvider(getActivity(),new SavedStateViewModelFactory(getActivity().getApplication(),getActivity())).get(MyViewModel.class);
        viewModel.generstor();
        viewModel.getCurrentScore().setValue(0);
        final FragmentQuestionBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_question,container,false);
        binding.setData(viewModel);
        binding.setLifecycleOwner(getActivity());
        final StringBuilder builder = new StringBuilder();
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button0:
                        builder.append("0");
                        break;
                    case R.id.button1:
                        builder.append("1");
                        break;
                    case R.id.button2:
                        builder.append("2");
                        break;
                    case R.id.button3:
                        builder.append("3");
                        break;
                    case R.id.button4:
                        builder.append("4");
                        break;
                    case R.id.button5:
                        builder.append("5");
                        break;
                    case R.id.button6:
                        builder.append("6");
                        break;
                    case R.id.button7:
                        builder.append("7");
                        break;
                    case R.id.button8:
                        builder.append("8");
                        break;
                    case R.id.button9:
                        builder.append("9");
                        break;
                    case R.id.buttonClecn:
                        builder.setLength(0);
                        break;
                }
                if(builder.length() == 0) {
                    binding.textView9.setText(getText(R.string.input_indicator));
                }
                else {
                    binding.textView9.setText(builder.toString());
                }
            }

        };

        binding.button0.setOnClickListener(listener);
        binding.button1.setOnClickListener(listener);
        binding.button2.setOnClickListener(listener);
        binding.button3.setOnClickListener(listener);
        binding.button4.setOnClickListener(listener);
        binding.button5.setOnClickListener(listener);
        binding.button6.setOnClickListener(listener);
        binding.button7.setOnClickListener(listener);
        binding.button8.setOnClickListener(listener);
        binding.button9.setOnClickListener(listener);
        binding.buttonClecn.setOnClickListener(listener);

        View.OnClickListener linster1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (builder.length() <= 0) {
                    builder.append("-1");
                }
                if (Integer.valueOf(builder.toString()).intValue() == viewModel.getAnswer().getValue()) {
                    viewModel.anserCorrect();
                    builder.setLength(0);
                    binding.textView9.setText(getString(R.string.answer_correct_message));
                   // builder.append(getString(R.string.answer_correct_message));
                }
                else  {
                    NavController navController = Navigation.findNavController(view);
                    if (viewModel.win_flag) {
                        navController.navigate(R.id.action_questionFragment_to_winFragment);
                        viewModel.win_flag = false;
                        viewModel.save();
                    }
                    else  {
                        navController.navigate(R.id.action_questionFragment_to_loseFragment);
                    }
                }
            }
        };
        binding.buttonSubmit.setOnClickListener(linster1);

        return binding.getRoot();
    }
}
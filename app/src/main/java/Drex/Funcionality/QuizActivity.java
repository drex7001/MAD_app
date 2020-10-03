package Drex.Funcionality;

import android.animation.Animator;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.drex.dashboard.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.model.value.IntegerValue;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView question,qCount,timer,quiz_category;
    private Button option1,option2,option3,option4;
    private List<Question> questionList;
    private int score;
    int quesNum;
    private CountDownTimer countDown;
    private FirebaseFirestore firestore;
    private int setNo;
    private Dialog LoadingDialog;
    String name,type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        question = findViewById(R.id.question);
        qCount = findViewById(R.id.qCount);
        timer = findViewById(R.id.timer);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);

        //LoadingDialog = new Dialog(QuizActivity.this);
        //LoadingDialog.setContentView(R.layout.loading_progressbar);
        //LoadingDialog.setCancelable(false);
        ///LoadingDialog.getWindow().setBackgroundDrawableResource(R.drawable.progress_background);
       // LoadingDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
       // LoadingDialog.show();

        name = getIntent().getExtras().getString("name");
        name.toLowerCase();
        type = getIntent().getExtras().getString("name");
        type.toLowerCase();

        firestore = FirebaseFirestore.getInstance();

        getQuestionsList();
        quesNum = 0;
        score = 0;
    }

    private void getQuestionsList(){
        questionList = new ArrayList<>();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("question/java/beginner");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionList.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    questionList.add(new Question(snapshot.getValue().toString(), "ds", "d", "sd", "sd", 2));
                    Toast.makeText(QuizActivity.this,"aaa",Toast.LENGTH_LONG);
                }
                setQuestion();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
//        firestore.collection("question").document("java").collection("beginner")
//                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                if(task.isSuccessful()) {
//                    QuerySnapshot questions = task.getResult();
//                    Log.d("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", String.valueOf(questions.size()));
//                    for (QueryDocumentSnapshot doc : questions) {
//                        questionList.add(new Question(doc.getString("question"),
//                                doc.getString("a"),
//                                doc.getString("b"),
//                                doc.getString("c"),
//                                doc.getString("d"),
//                                Integer.valueOf(doc.getString("answer"))
//                        ));
//                    }
//                    setQuestion();
//                }else{
//                    Toast.makeText(QuizActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
//                }
//               // LoadingDialog.cancel();
//            }
//        });
//        questionList.add(new Question("Question 1","A","B","C","D",1));
//        questionList.add(new Question("Question 2","A","B","C","D",2));
//        questionList.add(new Question("Question 3","A","B","C","D",3));
//        questionList.add(new Question("Question 4","A","B","C","D",4));
//        questionList.add(new Question("Question 5","A","B","C","D",4));


    }

    public void setQuestion(){
        timer.setText(String.valueOf(10));

        question.setText(questionList.get(0).getQuestion());
        option1.setText(questionList.get(0).getOptionA());
        option2.setText(questionList.get(0).getOptionB());
        option3.setText(questionList.get(0).getOptionC());
        option4.setText(questionList.get(0).getOptionD());

        qCount.setText(String.valueOf(1 + " | " + String.valueOf(questionList.size())));
        startTimer();
        quesNum = 0;
    }

    private void startTimer(){
            countDown = new CountDownTimer(12000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(millisUntilFinished < 10000)
                    timer.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                changeQuestion();
            }
        };

        countDown.start();
    }

    @Override
    public void onClick(View v) {
        int selectedOption = 0;

        switch(v.getId()){
            case R.id.option1 :
                selectedOption = 1;
                break;
            case R.id.option2 :
                selectedOption = 2;
                break;

            case R.id.option3 :
                selectedOption = 3;
                break;

            case R.id.option4 :
                selectedOption = 4;
                break;

            default:
        }
        countDown.cancel();
        checkAnswer(selectedOption, v);
    }

    private void checkAnswer(int selectedOption, View view){
        if(selectedOption == questionList.get(quesNum).getCorrectAns()){
            //Right answer
            ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            score ++;
        }
        else{
            //Wrong answer
            ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            switch (questionList.get(quesNum).getCorrectAns()){
                case 1:
                    option1.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 2:
                    option2.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 3:
                    option3.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 4:
                    option4.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
            }
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            public void run(){
                changeQuestion();
            }
        },1500);

    }


    private void changeQuestion(){
        if(quesNum < questionList.size() - 1){
            quesNum++;
            playAnim(question,0,0);
            playAnim(option1,0,1);
            playAnim(option2,0,2);
            playAnim(option3,0,3);
            playAnim(option4,0,4);

            qCount.setText(String.valueOf(quesNum+1) + " | " + String.valueOf(questionList.size()));
            timer.setText(String.valueOf(10));
            startTimer();
        }
        else{
            //goto score activity
            Intent intent = new Intent(QuizActivity.this,ScoreActivity.class);
            intent.putExtra("SCORE",String.valueOf(score) + " | " + String.valueOf(questionList.size()));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            //QuizActivity.this.finish();
        }
    }

    private void playAnim(final View view, final int value, final int viewNum){
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).
        setStartDelay(100).setInterpolator(new DecelerateInterpolator()).
        setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                if(value == 0){
                    switch (viewNum){
                        case 0:
                            ((TextView)view).setText(questionList.get(quesNum).getQuestion());
                            break;
                        case 1:
                            ((Button)view).setText(questionList.get(quesNum).getOptionA());
                            break;
                        case 2:
                            ((Button)view).setText(questionList.get(quesNum).getOptionB());
                            break;
                        case 3:
                            ((Button)view).setText(questionList.get(quesNum).getOptionC());
                            break;
                        case 4:
                            ((Button)view).setText(questionList.get(quesNum).getOptionD());
                            break;
                    }

                    if(viewNum != 0){
                        ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#B3D1EC")));
                    }

                    playAnim(view,1,viewNum);
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        countDown.cancel();
    }
}
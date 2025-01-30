package com.example.datingappandroid.activities.matching;

import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datingappandroid.R;
import com.example.datingappandroid.adapters.SwippingAdapter;
import com.example.datingappandroid.models.Swipping;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.SwipeableMethod;

import java.util.ArrayList;
import java.util.List;

public class MatchingActivity extends AppCompatActivity implements CardStackListener {
    public static List<Swipping> generateFakeData() {
        List<Swipping> fakeData = new ArrayList<>();
        // Thêm các tin nhắn giả vào danh sách
        fakeData.add(new Swipping("Coche", 28, "https://kenh14cdn.com/thumb_w/660/203336854389633024/2022/5/25/photo-1-1653461340935426739125.jpg", 10));
        fakeData.add(new Swipping("Peter", 22, "https://kenh14cdn.com/thumb_w/660/203336854389633024/2022/5/25/photo-1-1653461340935426739125.jpg", 20));
        fakeData.add(new Swipping("Snake", 21, "https://kenh14cdn.com/thumb_w/660/203336854389633024/2022/5/25/photo-1-1653461340935426739125.jpg", 30));
        fakeData.add(new Swipping("BuiTien", 16, "https://kenh14cdn.com/thumb_w/660/203336854389633024/2022/5/25/photo-1-1653461340935426739125.jpg", 5));
        fakeData.add(new Swipping("TienBui", 34, "https://kenh14cdn.com/thumb_w/660/203336854389633024/2022/5/25/photo-1-1653461340935426739125.jpg", 1));

        return fakeData;
    }
    List<Swipping> swippings = generateFakeData();

    private SwippingAdapter swippingAdapter;
    private CardStackLayoutManager layoutManager;
    private CardStackView stackView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        Fresco.initialize(this);

        setContentView(R.layout.activity_matching);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        swippingAdapter = new SwippingAdapter(swippings);
        stackView = findViewById(R.id.stack_view);
        stackView.setAdapter(swippingAdapter);

        layoutManager = new CardStackLayoutManager(this, this);
        layoutManager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual);
        layoutManager.setOverlayInterpolator(new LinearInterpolator());

        stackView.setLayoutManager(layoutManager);
        stackView.setAdapter(swippingAdapter);

        if (stackView.getItemAnimator() instanceof DefaultItemAnimator) {
            ((DefaultItemAnimator) stackView.getItemAnimator()).setSupportsChangeAnimations(false);
        }
    }

    @Override
    public void onCardDragging(Direction direction, float ratio) {

    }

    @Override
    public void onCardSwiped(Direction direction) {

    }

    @Override
    public void onCardRewound() {

    }

    @Override
    public void onCardCanceled() {

    }

    @Override
    public void onCardAppeared(View view, int position) {

    }

    @Override
    public void onCardDisappeared(View view, int position) {

    }
}
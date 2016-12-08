package com.ksu4040e071.recycleview;

/**
 * Created by nick on 2016/12/7.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class recycleView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycleview);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(
                        3, StaggeredGridLayoutManager.GAP_HANDLING_NONE));
        List<Member> memberList = new ArrayList<>();
        memberList.add(new Member(92, R.drawable.tourism01,"【苗栗/三義】世外桃源~卓也小屋(環境篇)",""));
        memberList.add(new Member(103, R.drawable.tourism02, "紀州名湯勝浦溫泉物語 細數日本文化點滴",""));
        memberList.add(new Member(234, R.drawable.tourism03, "台南鐵牛車關東煮「念水町」", ""));
        memberList.add(new Member(35, R.drawable.tourism04, "十分車站~~遊訪天燈的故鄉，感受十分幸福的氣息", ""));
        memberList.add(new Member(23, R.drawable.tourism05, "發現宜蘭天堂般海岸｜宜蘭東澳粉鳥林秘境沙灘｜粉鳥林秘境親子獨舟｜兩種玩法懶人包", ""));
        memberList.add(new Member(75, R.drawable.tourism06, "清水地熱~~體驗煮食泡腳的樂趣，感受暖暖的大自然氣息", ""));
        memberList.add(new Member(65, R.drawable.tourism07, "【基隆/中正】天然海蝕洞 ~仙洞巖", ""));
        memberList.add(new Member(12, R.drawable.tourism08, "2016士林官邸菊展「菊世聞名」11/27-12/11", ""));
        memberList.add(new Member(45, R.drawable.tourism09, "繁花似錦！洋紫荊的華美、艷紫荊的紅艷，秋末街景醉人心弦", ""));
        memberList.add(new Member(78, R.drawable.tourism10, "【明星旅遊趣】林玟誼拍戲空檔遊東京　歌舞伎町路上被找當男公關？！", ""));
        memberList.add(new Member(57, R.drawable.tourism11, "[德國] Bastei - 巴斯泰，鬼斧神工的奇石", ""));
        memberList.add(new Member(61, R.drawable.tourism12, "台北101法國耶誕市集！先了解4件事才不會失望，盡情感受濃濃節慶氣氛吧", ""));
        recyclerView.setAdapter(new MemberAdapter(this, memberList));
    }

    private class MemberAdapter extends
            RecyclerView.Adapter<MemberAdapter.ViewHolder> {
        private Context context;
        private LayoutInflater layoutInflater;
        private List<Member> memberList;

        public MemberAdapter(Context context, List<Member> memberList) {
            this.context = context;
            layoutInflater = LayoutInflater.from(context);
            this.memberList = memberList;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView ivImage;
            TextView tvId, tvName;
            View itemView;

            public ViewHolder(View itemView) {
                super(itemView);
                this.itemView = itemView;
                ivImage = (ImageView) itemView.findViewById(R.id.ivImage);
                tvId = (TextView) itemView.findViewById(R.id.tvId);
                tvName = (TextView) itemView.findViewById(R.id.tvName);
            }
        }

        @Override
        public int getItemCount() {
            return memberList.size();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            View itemView = layoutInflater.inflate(
                    R.layout.recycle_item, viewGroup, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int position) {
            final Member member = memberList.get(position);
            viewHolder.ivImage.setImageResource(member.getImage());
            //viewHolder.tvId.setText(String.valueOf(member.getId()));
            //viewHolder.tvName.setText(member.getName());
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageView imageView = new ImageView(context);
                    imageView.setImageResource(member.getImage());


                    Toast toast = new Toast(context);
                    toast.setView(imageView);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.show();
                }
            });
        }
    }
}

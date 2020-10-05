package ru.park.mail.lesson2;

import android.graphics.Color;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class DataSource {

    private static final DataSource ourInstance = new DataSource();
    private final List<NewsModel> list;

    private String[] mtitles = new String[]{
            "title1",
            "title2",
            "title3",
            "title4",
            "title5",
            "title6",
            "title7"
    };

    private int[] mColors = new int[]{
            Color.GREEN,
            Color.RED,
            Color.CYAN,
            Color.BLACK,
            Color.BLUE,
    };

    private DataSource() {
        list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            String title = mtitles[random.nextInt(mtitles.length)];
            String date = String.valueOf(new Date(random.nextInt()));
            int color = mColors[random.nextInt(mColors.length)];
            list.add(new NewsModel(title, date, color));
        }
    }

    static DataSource getInstance() {
        return ourInstance;
    }

    public List<NewsModel> getData() {
        return list;
    }


    public static class NewsModel {

        private String mTitle;
        private String mDate;
        private int mColor;

        public NewsModel(String title, String date, int color) {
            mTitle = title;
            mDate = date;
            mColor = color;
        }

        public String getTitle() {
            return mTitle;
        }

        public String getDate() {
            return mDate;
        }

        public int getColor() {
            return mColor;
        }


    }
}

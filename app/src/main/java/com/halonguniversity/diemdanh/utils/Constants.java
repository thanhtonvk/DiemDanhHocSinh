package com.halonguniversity.diemdanh.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;

import com.halonguniversity.diemdanh.entities.LoginResponse;
import com.halonguniversity.diemdanh.entities.SinhVien;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Constants {
    public static List<LoginResponse> loginResponses;
    public static int maloptc;
    public static SinhVien sinhVien;
    public static String url;
    public static float[] string2array(String embFace) {
        String[] emb = embFace.split(" ");
        int n = emb.length;
        float[] embFloat = new float[n];
        for (int i = 0; i < n; i++) {
            embFloat[i] = Float.parseFloat(emb[i]);
        }
        return embFloat;
    }

    public static String array2string(float[] emb) {
        String embFace = "";
        int n = emb.length;
        for (int i = 0; i < n; i++) {
            embFace += (emb[i] + " ");
        }
        return embFace.trim();
    }

    public static double cosineSimilarity(float[] vectorA, float[] vectorB) {
        float dotProduct = 0.0f;
        float normA = 0.0f;
        float normB = 0.0f;
        for (int i = 0; i < vectorA.length; i++) {
            dotProduct += vectorA[i] * vectorB[i];
            normA += Math.pow(vectorA[i], 2);
            normB += Math.pow(vectorB[i], 2);
        }
        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }
    public static File savebitmap(Context context, Bitmap bitmap, String fileName) throws IOException {
        String path = MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, fileName, null);
        Uri uri = Uri.parse(path);
        String realFilePath = RealPathUtils.getRealPath(context, uri);
        File file = new File(realFilePath);
        return file;
    }
}

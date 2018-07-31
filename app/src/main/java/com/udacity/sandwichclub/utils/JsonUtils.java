package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        try {
            JSONObject sandwichmenu = new JSONObject(json);

            //call name, mainName

            JSONObject name = sandwichmenu.getJSONObject("name");
            String mainName = name.getString("mainName");

            //call alsoKnownAs array by using 'for loop' to target objects in array

            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAsList = new ArrayList<>();

            for(int i=0; i < alsoKnownAs.length(); i++) {
                alsoKnownAsList.add( alsoKnownAs.getString(i) );
            }

            //call placeOfOrigin, description, Image

            String placeOfOrigin = sandwichmenu.getString("placeOfOrigin");
            String description = sandwichmenu.getString("description");
            String image = sandwichmenu.getString("image");

            //call ingredients array by using 'for loop' to target objects in array

            JSONArray ingredients = sandwichmenu.getJSONArray("ingredients");
            List<String> ingredientsList = new ArrayList<>();

            for (int i = 0; i < ingredients.length(); i++) {
                ingredientsList.add(ingredients.getString(i) );
            }

            //return new sandwich
            return new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, image, ingredientsList);
        }

        catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
}

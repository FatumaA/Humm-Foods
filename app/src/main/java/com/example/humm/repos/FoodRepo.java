package com.example.humm.repos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.humm.model.FoodProducts;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FoodRepo {

    private MutableLiveData<List<FoodProducts>> mutableFoodProductsList;

    public LiveData<List<FoodProducts>>  getFoodProducts(){
        if(mutableFoodProductsList == null){
            mutableFoodProductsList = new MutableLiveData<>();
            loadFoodProducts();
        }
        return mutableFoodProductsList;
    }
    private void loadFoodProducts(){
        List<FoodProducts> foodProductsList = new ArrayList<>();

        foodProductsList.add(new FoodProducts(UUID.randomUUID().toString(),"Fried Eggs", "Delicious eggs with cheese",
                100, true, "https://media1.s-nbcnews.com/j/newscms/2018_38/1368436/eggs-today-main-180917_880dee4fed6ebbb5659afba3186fea76.fit-1240w.jpg" ));

        foodProductsList.add(new FoodProducts(UUID.randomUUID().toString(),"Toast", "Toasted Bread with Jam",
                50, true, "https://cdn.pixabay.com/photo/2015/12/05/11/04/toast-1077984_960_720.jpg" ));

        foodProductsList.add(new FoodProducts(UUID.randomUUID().toString(),"Sweet Potatoes", "Filling sweet potatoes",
                120, true, "https://media.istockphoto.com/photos/baked-sweet-potato-picture-id184855907" ));

        foodProductsList.add(new FoodProducts(UUID.randomUUID().toString(),"Oats Porridge", "Warm hearty oat porridge",
                50, true, "https://cdn.pixabay.com/photo/2018/03/29/12/19/oats-3272113_960_720.jpg" ));

        foodProductsList.add(new FoodProducts(UUID.randomUUID().toString(),"Pilau Special", "traditional chicken pilau",
                300, true, "https://cdn.pixabay.com/photo/2015/10/01/14/26/fried-rice-967081_960_720.jpg" ));

        foodProductsList.add(new FoodProducts(UUID.randomUUID().toString(),"Butter Naan", "GF Naan with tikka chicken",
                700, true, "https://cdn.pixabay.com/photo/2015/05/10/05/34/naan-760528_960_720.jpg" ));

        foodProductsList.add(new FoodProducts(UUID.randomUUID().toString(),"Pasta Bolognese", "Pasta and minced meat",
                400, false, "https://cdn.pixabay.com/photo/2017/11/08/22/18/spaghetti-2931846_960_720.jpg" ));

        foodProductsList.add(new FoodProducts(UUID.randomUUID().toString(),"Ugali Kienyeji", "Ugali with Kienyeji chicken",
                200, true, "https://cdn.pixabay.com/photo/2016/08/30/18/45/grilled-1631727_960_720.jpg" ));

        foodProductsList.add(new FoodProducts(UUID.randomUUID().toString(),"Kenyan Chai", "Tea made the kenyan way",
                50, true, "https://cdn.pixabay.com/photo/2015/10/07/05/47/chai-975685_960_720.jpg" ));

        foodProductsList.add(new FoodProducts(UUID.randomUUID().toString(),"Orange Juice", "Freshly made fruit juice",
                50, false, "https://cdn.pixabay.com/photo/2017/01/20/15/06/orange-1995056_960_720.jpg" ));

        foodProductsList.add(new FoodProducts(UUID.randomUUID().toString(),"House Coffee", "Kahwa Chungu re-imagined",
                50, true, "https://cdn.pixabay.com/photo/2015/10/12/14/54/coffee-983955_960_720.jpg" ));

        foodProductsList.add(new FoodProducts(UUID.randomUUID().toString(),"Red Velvet Cake", "What can we say?",
                100, false, "https://cdn.pixabay.com/photo/2016/02/29/00/19/cake-1227842_960_720.jpg" ));

        foodProductsList.add(new FoodProducts(UUID.randomUUID().toString(),"Chocolate Cake", "For the chocolate lovers",
                100, true, "https://cdn.pixabay.com/photo/2017/01/23/08/45/cake-2001781_960_720.jpg" ));

        foodProductsList.add(new FoodProducts(UUID.randomUUID().toString(),"Vanilla Cake", "Good old plain cake",
                100, true, "https://cdn.pixabay.com/photo/2016/10/25/13/43/christmas-stollen-1768907_960_720.jpg" ));

        foodProductsList.add(new FoodProducts(UUID.randomUUID().toString(),"Passion Juice", "Fresh fruit juice",
                50, true, "https://cdn.pixabay.com/photo/2018/05/17/15/33/cocktail-3408834_960_720.jpg" ));

        foodProductsList.add(new FoodProducts(UUID.randomUUID().toString(),"Mineral Water", "We stock Aquamist",
                30, true, "https://cdn.pixabay.com/photo/2017/02/28/08/50/water-2105211_960_720.jpg" ));



        mutableFoodProductsList.setValue(foodProductsList);
    }
}

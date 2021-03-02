package com.xacalet.bffinder.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson


class DogListViewModel : ViewModel() {

    val dogs: MutableLiveData<List<Dog>> =
        MutableLiveData(Gson().fromJson(dogsJson, Array<Dog>::class.java).toMutableList())

    fun adoptDog(dog: Dog) {
        val index = dogs.value?.indexOf(dog) ?: -1
        if (index != -1) {
            dogs.value?.toMutableList()?.also { it[index].isBff = true }
        }
    }

    companion object {
        private const val dogsJson = "[\n" +
                "  {\n" +
                "    \"name\": \"Debby\",\n" +
                "    \"gender\": \"Female\",\n" +
                "    \"months\": 32,\n" +
                "    \"breed\": \"Ibizan Hound\",\n" +
                "    \"picUrl\": \"https://images.dog.ceo/breeds/hound-ibizan/n02091244_5400.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Bucket\",\n" +
                "    \"gender\": \"Male\",\n" +
                "    \"months\": 12,\n" +
                "    \"breed\": \"Norwegian Buhund\",\n" +
                "    \"picUrl\": \"https://images.dog.ceo/breeds/buhund-norwegian/hakon2.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Phil\",\n" +
                "    \"gender\": \"Male\",\n" +
                "    \"months\": 32,\n" +
                "    \"breed\": \"Irish Terrier\",\n" +
                "    \"picUrl\": \"https://images.dog.ceo/breeds/terrier-irish/n02093991_1883.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Spark\",\n" +
                "    \"gender\": \"Male\",\n" +
                "    \"months\": 48,\n" +
                "    \"breed\": \"Pitbull\",\n" +
                "    \"picUrl\": \"https://images.dog.ceo/breeds/pitbull/IMG_20190826_121528_876.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Kat\",\n" +
                "    \"gender\": \"Female\",\n" +
                "    \"months\": 95,\n" +
                "    \"breed\": \"Beagle\",\n" +
                "    \"picUrl\": \"https://images.dog.ceo/breeds/beagle/n02088364_13214.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Sakura\",\n" +
                "    \"gender\": \"Female\",\n" +
                "    \"months\": 50,\n" +
                "    \"breed\": \"Akita\",\n" +
                "    \"picUrl\": \"https://images.dog.ceo/breeds/akita/An_Akita_Inu_resting.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Simba\",\n" +
                "    \"gender\": \"Male\",\n" +
                "    \"months\": 16,\n" +
                "    \"breed\": \"Chow\",\n" +
                "    \"picUrl\": \"https://images.dog.ceo/breeds/chow/n02112137_2319.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Enya\",\n" +
                "    \"gender\": \"Female\",\n" +
                "    \"months\": 80,\n" +
                "    \"breed\": \"Pug\",\n" +
                "    \"picUrl\": \"https://images.dog.ceo/breeds/pug/DSCF7495-2.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Harry\",\n" +
                "    \"gender\": \"Male\",\n" +
                "    \"months\": 30,\n" +
                "    \"breed\": \"Pomeranian\",\n" +
                "    \"picUrl\": \"https://images.dog.ceo/breeds/pomeranian/n02112018_514.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Jacky\",\n" +
                "    \"gender\": \"Female\",\n" +
                "    \"months\": 26,\n" +
                "    \"breed\": \"Rottweiler\",\n" +
                "    \"picUrl\": \"https://images.dog.ceo/breeds/rottweiler/n02106550_8166.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Lana\",\n" +
                "    \"gender\": \"Female\",\n" +
                "    \"months\": 8,\n" +
                "    \"breed\": \"German Shepherd\",\n" +
                "    \"picUrl\": \"https://images.dog.ceo/breeds/germanshepherd/n02106662_9936.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Lana\",\n" +
                "    \"gender\": \"Female\",\n" +
                "    \"months\": 4,\n" +
                "    \"breed\": \"Dachshund\",\n" +
                "    \"picUrl\": \"https://images.dog.ceo/breeds/dachshund/daschund-1.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Lana\",\n" +
                "    \"gender\": \"Female\",\n" +
                "    \"months\": 10,\n" +
                "    \"breed\": \"Husky\",\n" +
                "    \"picUrl\": \"https://images.dog.ceo/breeds/husky/n02110185_519.jpg\"\n" +
                "  }\n" +
                "]"
    }
}

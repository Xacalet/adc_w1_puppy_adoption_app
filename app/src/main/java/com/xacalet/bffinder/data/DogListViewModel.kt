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
                "    \"id\": 1,\n" +
                "    \"name\": \"Debby\",\n" +
                "    \"gender\": \"Female\",\n" +
                "    \"months\": 32,\n" +
                "    \"breed\": \"Ibizan Hound\",\n" +
                "    \"description\": \"She is very smart, knows 'sit', and is ready to learn many more tricks! She enjoys treats but is still figuring out what she needs to do to earn them! She loves cuddles and is always excited to see new people. She might be a bit much for very small children due to her jumpiness, but a family with older kids that enjoyed playing with her could help burn off some of her extra puppy energy. She would likely be okay with a calmer dog near her size, but larger rowdy dogs make her very anxious.\",\n" +
                "    \"picUrl\": \"https://images.dog.ceo/breeds/hound-ibizan/n02091244_5400.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 2,\n" +
                "    \"name\": \"Bucket\",\n" +
                "    \"gender\": \"Male\",\n" +
                "    \"months\": 12,\n" +
                "    \"breed\": \"Norwegian Buhund\",\n" +
                "    \"description\": \"He is very smart, knows 'sit', and is ready to learn many more tricks! He enjoys treats but is still figuring out what she needs to do to earn them! He loves cuddles and is always excited to see new people. He might be a bit much for very small children due to his jumpiness, but a family with older kids that enjoyed playing with his could help burn off some of his extra puppy energy. He would likely be okay with a calmer dog near his size, but larger rowdy dogs make his very anxious.\",\n" +
                "    \"picUrl\": \"https://images.dog.ceo/breeds/buhund-norwegian/hakon2.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 3,\n" +
                "    \"name\": \"Phil\",\n" +
                "    \"gender\": \"Male\",\n" +
                "    \"months\": 32,\n" +
                "    \"breed\": \"Irish Terrier\",\n" +
                "    \"description\": \"He is very smart, knows 'sit', and is ready to learn many more tricks! He enjoys treats but is still figuring out what she needs to do to earn them! He loves cuddles and is always excited to see new people. He might be a bit much for very small children due to his jumpiness, but a family with older kids that enjoyed playing with his could help burn off some of his extra puppy energy. He would likely be okay with a calmer dog near his size, but larger rowdy dogs make his very anxious.\",\n" +
                "    \"picUrl\": \"https://images.dog.ceo/breeds/terrier-irish/n02093991_1883.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 4,\n" +
                "    \"name\": \"Spark\",\n" +
                "    \"gender\": \"Male\",\n" +
                "    \"months\": 48,\n" +
                "    \"breed\": \"Pitbull\",\n" +
                "    \"description\": \"He is very smart, knows 'sit', and is ready to learn many more tricks! He enjoys treats but is still figuring out what she needs to do to earn them! He loves cuddles and is always excited to see new people. He might be a bit much for very small children due to his jumpiness, but a family with older kids that enjoyed playing with his could help burn off some of his extra puppy energy. He would likely be okay with a calmer dog near his size, but larger rowdy dogs make his very anxious.\",\n" +
                "    \"picUrl\": \"https://images.dog.ceo/breeds/pitbull/IMG_20190826_121528_876.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 5,\n" +
                "    \"name\": \"Kat\",\n" +
                "    \"gender\": \"Female\",\n" +
                "    \"months\": 95,\n" +
                "    \"breed\": \"Beagle\",\n" +
                "    \"picUrl\": \"https://images.dog.ceo/breeds/beagle/n02088364_13214.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 6,\n" +
                "    \"name\": \"Sakura\",\n" +
                "    \"gender\": \"Female\",\n" +
                "    \"months\": 50,\n" +
                "    \"breed\": \"Akita\",\n" +
                "    \"description\": \"She is very smart, knows 'sit', and is ready to learn many more tricks! She enjoys treats but is still figuring out what she needs to do to earn them! She loves cuddles and is always excited to see new people. She might be a bit much for very small children due to her jumpiness, but a family with older kids that enjoyed playing with her could help burn off some of her extra puppy energy. She would likely be okay with a calmer dog near her size, but larger rowdy dogs make her very anxious.\",\n" +
                "    \"picUrl\": \"https://images.dog.ceo/breeds/akita/An_Akita_Inu_resting.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 7,\n" +
                "    \"name\": \"Simba\",\n" +
                "    \"gender\": \"Male\",\n" +
                "    \"months\": 16,\n" +
                "    \"breed\": \"Chow\",\n" +
                "    \"description\": \"He is very smart, knows 'sit', and is ready to learn many more tricks! He enjoys treats but is still figuring out what she needs to do to earn them! He loves cuddles and is always excited to see new people. He might be a bit much for very small children due to his jumpiness, but a family with older kids that enjoyed playing with his could help burn off some of his extra puppy energy. He would likely be okay with a calmer dog near his size, but larger rowdy dogs make his very anxious.\",\n" +
                "    \"picUrl\": \"https://images.dog.ceo/breeds/chow/n02112137_2319.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 8,\n" +
                "    \"name\": \"Enya\",\n" +
                "    \"gender\": \"Female\",\n" +
                "    \"months\": 80,\n" +
                "    \"breed\": \"Pug\",\n" +
                "    \"description\": \"She is very smart, knows 'sit', and is ready to learn many more tricks! She enjoys treats but is still figuring out what she needs to do to earn them! She loves cuddles and is always excited to see new people. She might be a bit much for very small children due to her jumpiness, but a family with older kids that enjoyed playing with her could help burn off some of her extra puppy energy. She would likely be okay with a calmer dog near her size, but larger rowdy dogs make her very anxious.\",\n" +
                "    \"picUrl\": \"https://images.dog.ceo/breeds/pug/DSCF7495-2.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 9,\n" +
                "    \"name\": \"Harry\",\n" +
                "    \"gender\": \"Male\",\n" +
                "    \"months\": 30,\n" +
                "    \"breed\": \"Pomeranian\",\n" +
                "    \"description\": \"He is very smart, knows 'sit', and is ready to learn many more tricks! He enjoys treats but is still figuring out what she needs to do to earn them! He loves cuddles and is always excited to see new people. He might be a bit much for very small children due to his jumpiness, but a family with older kids that enjoyed playing with his could help burn off some of his extra puppy energy. He would likely be okay with a calmer dog near his size, but larger rowdy dogs make his very anxious.\",\n" +
                "    \"picUrl\": \"https://images.dog.ceo/breeds/pomeranian/n02112018_514.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 10,\n" +
                "    \"name\": \"Jacky\",\n" +
                "    \"gender\": \"Female\",\n" +
                "    \"months\": 26,\n" +
                "    \"breed\": \"Rottweiler\",\n" +
                "    \"description\": \"She is very smart, knows 'sit', and is ready to learn many more tricks! She enjoys treats but is still figuring out what she needs to do to earn them! She loves cuddles and is always excited to see new people. She might be a bit much for very small children due to her jumpiness, but a family with older kids that enjoyed playing with her could help burn off some of her extra puppy energy. She would likely be okay with a calmer dog near her size, but larger rowdy dogs make her very anxious.\",\n" +
                "    \"picUrl\": \"https://images.dog.ceo/breeds/rottweiler/n02106550_8166.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 11,\n" +
                "    \"name\": \"Lana\",\n" +
                "    \"gender\": \"Female\",\n" +
                "    \"months\": 8,\n" +
                "    \"breed\": \"German Shepherd\",\n" +
                "    \"description\": \"She is very smart, knows 'sit', and is ready to learn many more tricks! She enjoys treats but is still figuring out what she needs to do to earn them! She loves cuddles and is always excited to see new people. She might be a bit much for very small children due to her jumpiness, but a family with older kids that enjoyed playing with her could help burn off some of her extra puppy energy. She would likely be okay with a calmer dog near her size, but larger rowdy dogs make her very anxious.\",\n" +
                "    \"picUrl\": \"https://images.dog.ceo/breeds/germanshepherd/n02106662_9936.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 12,\n" +
                "    \"name\": \"Fiona\",\n" +
                "    \"gender\": \"Female\",\n" +
                "    \"months\": 4,\n" +
                "    \"breed\": \"Dachshund\",\n" +
                "    \"description\": \"She is very smart, knows 'sit', and is ready to learn many more tricks! She enjoys treats but is still figuring out what she needs to do to earn them! She loves cuddles and is always excited to see new people. She might be a bit much for very small children due to her jumpiness, but a family with older kids that enjoyed playing with her could help burn off some of her extra puppy energy. She would likely be okay with a calmer dog near her size, but larger rowdy dogs make her very anxious.\",\n" +
                "    \"picUrl\": \"https://images.dog.ceo/breeds/dachshund/daschund-1.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 13,\n" +
                "    \"name\": \"Karl\",\n" +
                "    \"gender\": \"Male\",\n" +
                "    \"months\": 10,\n" +
                "    \"breed\": \"Husky\",\n" +
                "    \"description\": \"He is very smart, knows 'sit', and is ready to learn many more tricks! He enjoys treats but is still figuring out what she needs to do to earn them! He loves cuddles and is always excited to see new people. He might be a bit much for very small children due to his jumpiness, but a family with older kids that enjoyed playing with his could help burn off some of his extra puppy energy. He would likely be okay with a calmer dog near his size, but larger rowdy dogs make his very anxious.\",\n" +
                "    \"picUrl\": \"https://images.dog.ceo/breeds/husky/n02110185_519.jpg\"\n" +
                "  }\n" +
                "]"
    }
}

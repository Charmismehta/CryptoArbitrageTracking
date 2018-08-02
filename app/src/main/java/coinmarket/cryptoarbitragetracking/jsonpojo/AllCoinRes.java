package coinmarket.cryptoarbitragetracking.jsonpojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllCoinRes {
    @SerializedName("data")
    @Expose
    public Data data;
    @SerializedName("metadata")
    @Expose
    public Metadata metadata;

    public class Data {

        @SerializedName("1")
        @Expose
        public Details details;

        public class Details {

            @SerializedName("id")
            @Expose
            public int id;
            @SerializedName("name")
            @Expose
            public String name;
            @SerializedName("symbol")
            @Expose
            public String symbol;
            @SerializedName("website_slug")
            @Expose
            public String websiteSlug;
            @SerializedName("rank")
            @Expose
            public int rank;
            @SerializedName("circulating_supply")
            @Expose
            public float circulatingSupply;
            @SerializedName("total_supply")
            @Expose
            public float totalSupply;
            @SerializedName("max_supply")
            @Expose
            public float maxSupply;
            @SerializedName("quotes")
            @Expose
            public Quotes quotes;
            @SerializedName("last_updated")
            @Expose
            public int lastUpdated;

            public class Quotes {

                @SerializedName("USD")
                @Expose
                public USD uSD;

                public class USD {

                    @SerializedName("price")
                    @Expose
                    public float price;
                    @SerializedName("volume_24h")
                    @Expose
                    public float volume24h;
                    @SerializedName("market_cap")
                    @Expose
                    public float marketCap;
                    @SerializedName("percent_change_1h")
                    @Expose
                    public float percentChange1h;
                    @SerializedName("percent_change_24h")
                    @Expose
                    public float percentChange24h;
                    @SerializedName("percent_change_7d")
                    @Expose
                    public float percentChange7d;
                }
            }
        }
    }

    public class Metadata {

        @SerializedName("timestamp")
        @Expose
        public int timestamp;
        @SerializedName("num_cryptocurrencies")
        @Expose
        public int numCryptocurrencies;
        @SerializedName("error")
        @Expose
        public Object error;
    }
}

package org.mcclone.mongodb;

import com.google.common.hash.Hashing;
import org.bson.Document;
import org.junit.Test;

import java.nio.charset.Charset;

/**
 * Created by Administrator on 2017/12/17.
 */
public class ShardMongoCollectionTest {
    @Test
    public void count() throws Exception {
        System.out.println(ShardMongoClient.create().shardMongoCollection("test").count());
    }

    @Test
    public void insertOne() throws Exception {
        ShardMongoClient.ShardMongoCollection shardMongoCollection = ShardMongoClient.create().shardMongoCollection("test");
        for (int i = 0; i < 100; i++) {
            Document document = new Document();
            document.put("_id", i);
            document.put("name", "asdfsdf&&sd");
            shardMongoCollection.insertOne(document);
        }
    }

    @Test
    public void testHash() throws Exception {
//        System.out.println(Hashing.MD5.hash("123"));
//        System.out.println(Hashing.MD5.hash("123456"));
//        System.out.println(Hashing.MD5.hash("1234567890"));
        System.out.println(Hashing.crc32().hashString("asdasdsda", Charset.defaultCharset()));
        System.out.println(Hashing.crc32().hashString("asdasdsda", Charset.defaultCharset()).padToLong() % 16384);
    }

}
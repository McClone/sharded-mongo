package org.mcclone.mongodb;

import com.google.common.hash.Hashing;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
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
            document.put("_id", RandomStringUtils.randomAscii(15));
            document.put("name", "asdfsdf&&sd");
            shardMongoCollection.insertOne(document);
        }
    }

    @Test
    public void testHash() throws Exception {
//        System.out.println(Hashing.MD5.hash("123"));
//        System.out.println(Hashing.MD5.hash("123456"));
//        System.out.println(Hashing.MD5.hash("1234567890"));
        System.out.println(Hashing.crc32().hashString(DigestUtils.md5Hex("1234567890"), Charset.defaultCharset()).padToLong());
    }

}
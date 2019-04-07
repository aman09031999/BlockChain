package blockchain;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.util.*;
public class Block 
{
    private int index;
    private long timestamp;
    private String hash;
    private String previoushash;
    private String data;
    private int nonce;
    
    public Block(int index, long timestamp, String previoushash, String data)
    {
        this.index = index; 
        this.timestamp = timestamp; 
        this.previoushash = previoushash;
        this.data = data;
        nonce = 0;
        hash = Block.calculateHash(this);
    }
    
    public int getIndex()
    {
        return this.index;
    }
    public long getTimestamp()
    {
        return this.timestamp;
    }
    public String getHash()
    {
        return this.hash;
    }
    public String getPreviousHash()
    {
        return this.previoushash;
    }
    public String getData()
    {
        return this.data;
    }
    
    public String str()
    {
        return index + timestamp + previoushash + nonce;
    }
    
    public String toString()        
    {
        StringBuilder builder= new StringBuilder();
        builder.append("Block # ").append(index).
                append(" [previousHash : ").append(previoushash).append(", ").
                append("Timestamp : ").append(new Date(timestamp)).append(", ").
                append("Data : ").append(data).append(", ").
                append("Hash : ").append(hash).append("]");
        
        return builder.toString();
    }
    public static String calculateHash(Block block)
    {
        if(block != null)
        {
            MessageDigest digest = null;
            try
            {
                digest = MessageDigest.getInstance("SHA-256");
            }
            catch(NoSuchAlgorithmException e)
            {
                System.out.println("No Such Algorithm Found!!!");
                return null;
            }
            
            String txt = block.str();
            final byte bytes[] = digest.digest(txt.getBytes());
            final StringBuilder builder = new StringBuilder();
            
            for(final byte b : bytes)
            {
                String hex = Integer.toHexString(0xff & b);
                
                if(hex.length() == 1)
                    builder.append('0');
                
                builder.append(hex);
            }
            
            return builder.toString();
        }
            return null;
    }
    
    
    public void mineBlock(int difficulty)
    {
        nonce = 0;
        while(!getHash().substring(0, difficulty).equals(Utils.zeros(difficulty)))
        {
            nonce++;
            hash = Block.calculateHash(this);
        }
    }
}

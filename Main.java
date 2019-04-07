package blockchain;

public class Main 
{
    public static void main(String[] args) 
    {
        BlockChain blockchain = new BlockChain(3);
        blockchain.addBlock(blockchain.newBlock("Bitcoin-1xyz"));
        blockchain.addBlock(blockchain.newBlock("Bitcoin-2abc"));
        blockchain.addBlock(blockchain.newBlock("Bitcoin-3pqr"));
         System.out.println("BlockChain valide   : " + blockchain.isBlockChainValid());
        System.out.println(blockchain);
        /*
            System.out.println("BlockChain valide   : " + blockchain.isBlockChainValid());
            System.out.println(blockchain);
        */
        
        blockchain.addBlock(new Block(15,System.currentTimeMillis(),"aabcbc","Block Invalid"));
        System.out.println("BlockChain valide   : " + blockchain.isBlockChainValid());
        System.out.println(blockchain);
        
        
        
    }        
}

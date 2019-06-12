package minecraft;

import java.util.ArrayList;

public class MinecraftApp {

    public static void main(String[] args) 
    {
        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(new Grass());
        blocks.add(new Wood());
        blocks.add(new Brick());
        blocks.add(new Land());
        for(Block block : blocks)
        {
            ArrayList<Block> droppedBlocks = block.dropItems(Tool.ToolType.Hammer);
            System.out.println(block.getName() + " dropped: ");
            for(Block droppedBlock : droppedBlocks)
            {
                System.out.print(block.getName() + ",");
            }
            System.out.println();
        }
    }
    
}

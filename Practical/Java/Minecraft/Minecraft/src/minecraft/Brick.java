package minecraft;

import java.util.ArrayList;

public class Brick extends Block 
{
    @Override
    public ArrayList<Block> dropItems(Tool.ToolType type) {
        ArrayList<Block> blocks = new ArrayList<>();
        switch(type)
        {
            case Hammer:
                blocks.add(new Brick());
                blocks.add(new Brick());
                break;
            case Sword:
                blocks.add(new Brick());
                break;
            case Shovel:
                blocks.add(new Land());
                break;
            default:
                break;
        }
        return blocks;
    }
    
     @Override
    public String getName() {
        return "Brick";
    }
}

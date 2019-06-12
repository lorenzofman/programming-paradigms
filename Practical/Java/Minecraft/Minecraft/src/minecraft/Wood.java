package minecraft;

import java.util.ArrayList;

public class Wood extends Block 
{
    @Override
    public ArrayList<Block> dropItems(Tool.ToolType type) {
        ArrayList<Block> blocks = new ArrayList<>();
        switch(type)
        {
            case Hammer:
                blocks.add(new Wood());
                blocks.add(new Wood());
                blocks.add(new Wood());
                blocks.add(new Wood());
                break;
            case Sword:
                break;
            case Shovel:
                blocks.add(new Wood());
                break;
            default:
                break;
        }
        return blocks;
    }
    
     @Override
    public String getName() {
        return "Wood";
    }
    
}

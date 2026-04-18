public abstract class StatusEffect {
    private int duration;

    public StatusEffect(){
        this.duration = 2;
    }

    public void apply(Combatant c, GameLog log){

    }

    public void tick(Combatant c){

    }

    //added new method
    public void removeEffect(Combatant c, GameLog log){

    }

    public boolean isExpired(){
        if(getDuration() <=0){
            return true;
        }
        else{
            return false;
        }

    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration(){
        return this.duration;
    }

    public String getStatusName(){
        return "";
    }
}

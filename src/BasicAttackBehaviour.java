public class BasicAttackBehaviour implements EnemybehaviourStrategy {
    @Override
    public Action decideAction(Enemy self, BattleEngine context) {
        return new BasicAttack();
    }
}

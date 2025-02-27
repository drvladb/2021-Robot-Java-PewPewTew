package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShooterPulseCommand extends CommandBase{
    
    private double speed;
    private Shooter shooter;

    public ShooterPulseCommand(Shooter shooter, double speed) {
        addRequirements(shooter);
        this.shooter = shooter;
        this.speed = speed;
    }

    @Override
    public void execute() {
        if ((shooter.getPulseTime()/500)%20<=6) {
            if (shooter.getSpeed() > speed+500)
                shooter.coast();
            else
                shooter.setSpeed(speed);
        } else
            shooter.coast();
    }

}

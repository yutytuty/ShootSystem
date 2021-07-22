package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.spikes2212.command.genericsubsystem.commands.MoveGenericSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.ShootSubsystem;

public class OI /*Gevald*/ {
    private Joystick left;

    private MoveGenericSubsystem shootSystem;

    private ShootSubsystem shootSubsystem;
    private MoveGenericSubsystem shootCommand;

    public OI() {
        Button shoot = new JoystickButton(left, 5);

        this.shootSubsystem = new ShootSubsystem(new WPI_TalonSRX(RobotMap.CAN.SHOOT_TALON), new WPI_VictorSPX(RobotMap.CAN.SHOOT_VICTOR));
        this.shootCommand = new MoveGenericSubsystem(this.shootSubsystem, ShootSubsystem.SPEED);

        shoot.whileHeld(shootCommand);
    }
}

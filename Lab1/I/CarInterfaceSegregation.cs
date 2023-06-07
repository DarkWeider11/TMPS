using System;
using System.Collections.Generic;
using System.Text;

namespace Lab1.I
{
    internal class CarInterfaceSegregation : IMoveX, IMoveY
    {
        private double x = 0;
        private double y = 0;
        public void MoveForward()
        {
            x += 0.5;
        }

        public void MoveBackward()
        {
            x -= 0.5;
        }

        public void MoveLeft()
        {
            y -= 0.5;
        }

        public void MoveRight()
        {
            y += 0.5;
        }
    }
}

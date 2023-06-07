using System;
using System.Collections.Generic;
using System.Text;

namespace Lab1.I
{
    internal class TrainSegregation : IMoveX
    {
        private double x = 0;
        public void MoveForward()
        {
            x += 0.5;
        }

        public void MoveBackward()
        {
            x -= 0.5;
        }
    }
}

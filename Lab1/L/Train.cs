using System;
using System.Collections.Generic;
using System.Text;

namespace Lab1.L
{
    internal class Train : IMove
    {
        private double x = 0;
        public void MoveForward()
        {
            x += 1;
        }

        public void MoveBackward()
        {
            x -= 1;
        }

        public void MoveLeft()
        {
            throw new NotImplementedException();
        }

        public void MoveRight()
        {
            throw new NotImplementedException();
        }
    }
}

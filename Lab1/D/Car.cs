using System;
using System.Collections.Generic;
using System.Text;

namespace Lab1.D
{
    internal class Car
    {

        public void TurnOn()
        {
            BurnFuel();
        }

        public void TurnOn(string a, int b)
        {

        }
        public void BurnFuel()
        {
            Console.WriteLine("*burning fuel*");
        }
    }
}

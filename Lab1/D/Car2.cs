using System;
using System.Collections.Generic;
using System.Text;

namespace Lab1.D
{
    internal class Car2
    {
        private IEngine _engine;

        public Car2(IEngine engine)
        {
            _engine = engine;
        }

        public void TurnOn()
        {
            _engine.BurnFuel();
        }
    }
}

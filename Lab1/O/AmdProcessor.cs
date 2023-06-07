using System;
using System.Collections.Generic;
using System.Text;

namespace Lab1.O
{
    internal class AmdProcessor : IWork
    {
        private int _cores;

        public AmdProcessor(int cores)
        {
            _cores = cores;
        }

        public void Work()
        {
            Console.WriteLine($"Working {_cores} cores with 8 threads!");
        }
    }
}

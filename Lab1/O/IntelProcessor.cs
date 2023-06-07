using System;
using System.Collections.Generic;
using System.Text;

namespace Lab1.O
{
    internal class IntelProcessor : IWork
    {
        private int _cores;

        public IntelProcessor(int cores)
        {
            _cores = cores;
        }

        public void Work()
        {
            Console.WriteLine($"Working {_cores} cores with 4 threads!");
        }
    }
}

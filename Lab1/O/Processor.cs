using System;
using System.Collections.Generic;
using System.Text;

namespace Lab1.O
{
    internal class Processor
    {
        private string _name;
        private int _cores;

        public Processor(string name, int cores)
        {
            _name = name;
            _cores = cores;
        }

        public void Work()
        {   
            if (_name == "amd")
            {
                Console.WriteLine($"Working {_cores} cores with 8 threads!");
            }
            else if (_name == "intel")
            {
                Console.WriteLine($"Working {_cores} cores with 4 threads!");
            }

        }
    }
}

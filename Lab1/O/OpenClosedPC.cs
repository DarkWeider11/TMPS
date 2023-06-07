using System;
using System.Collections.Generic;
using System.Text;

namespace Lab1.O
{
    internal class OpenClosedPC
    {
        private string _vendorName;
        private Processor _processor;

        public OpenClosedPC(string vendorName, Processor processor)
        {
            _vendorName = vendorName;
            _processor = processor;
        }

        public void ChangeProcessor(string name, int cores)
        {
            _processor = new Processor(name, cores);
        }

        public void StartProcessor()
        {
            _processor.Work();
        }
    }
}

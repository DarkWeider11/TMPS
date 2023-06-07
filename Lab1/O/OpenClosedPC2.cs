using System;
using System.Collections.Generic;
using System.Text;

namespace Lab1.O
{
    internal class OpenClosedPC2
    {
        private string _vendorName;
        private IWork _processor;

        public OpenClosedPC2(string vendorName, IWork processor)
        {
            _vendorName = vendorName;
            _processor = processor;
        }

        public void ChangeAmdProcessor(int cores)
        {
            _processor = new AmdProcessor(cores);
        }
        public void ChangeIntelProcessor(int cores)
        {
            _processor = new IntelProcessor(cores);
        }

        public void StartProcessor()
        {
            _processor.Work();
        }
    }
}

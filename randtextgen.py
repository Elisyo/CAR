import random
import sys
import getopt


help_msg = 'Usage: randtextgen <options>\nOptions:\n-h, --help       : this help\n-n, --nlines <n> : number of generated lines (def: 10)\n-w, --wline  <n> : number of words per line  (def: 10)\n-d, --dict <file>: specify the dictionary (def: /usr/share/dict/words)\n-o, --output <file> : the output file (def: standard output)'

def main() :
    nlines = 10
    wline = 10
    flines = []
    dict = '/usr/share/dict/words'
    outfile = sys.stdout

    try:
        opts, args = getopt.getopt(sys.argv[1:], "hn:w:d:o:", ["help","nlines", "wline", "dict", "output"])
    except getopt.error, msg:
        print msg
        print "for help use --help"
        sys.exit(2)

    for o, a in opts:
        if o in ("-h", "--help"):
            print help_msg
            sys.exit(0)
        if o in ("-n", "--nlines"):
            nlines = int(a)
            print 'nlines : ', nlines
        if o in ("-w", "--wline"):
            wline = int(a)
            print 'wline : ', wline
        if o in ("-d", "--dict"):
            dict = a
            print 'dict : ', dict
        if o in ("-o", "--output"):
            outfile = open(a, 'w')
            print 'outfile : ', a

    # print "Option processed"
    
    f = open(dict, 'r')

    for line in f :
        flines.append(line[0:-1])


    for nl in range(0, nlines-1) :
        s = ''
        for w in range(0, wline-1) :
            s = s + flines[random.randrange(0,len(flines))] + ' '

        print >> outfile, s
    
if __name__ == "__main__":
    main()



